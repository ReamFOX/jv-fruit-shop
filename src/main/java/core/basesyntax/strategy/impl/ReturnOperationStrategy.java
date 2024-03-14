package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationStrategy implements OperationHandler {
    private final FruitDao fruitDao;

    public ReturnOperationStrategy(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void execute(String fruitName, int quantity) {
        Fruit fruit = fruitDao.get(fruitName);
        if (fruit.getSold() < quantity) {
            throw new RuntimeException("Not enough fruits were sold to "
                    + "fulfill the request");
        }
        int newQuantity = fruit.getQuantity() + quantity;
        fruit.setQuantity(newQuantity);
        fruit.setSold(fruit.getSold() - quantity);
        fruitDao.update(fruit);
    }
}
