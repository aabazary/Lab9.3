package edu.sdccd.cisc191;

/**
 * Producers creates a number of new Items and sends them to a Warehouse
 * Adapted from Tasha Frankie and Allan Schougaard
 */
public class Producer extends Thread
{
    private final String name;
    private final Warehouse warehouse;
    private final int numberOfItemsToProduce;

    public Producer(String givenName, Warehouse givenWarehouse, int givenNumberOfItemsToProduce)
    {
        name = givenName;
        warehouse = givenWarehouse;
        numberOfItemsToProduce = givenNumberOfItemsToProduce;
    }

    @Override
    public void run()
    {
        System.out.println(name + " running in Thread: " + Thread.currentThread().getName());
        Item[] batch = new Item[numberOfItemsToProduce];
        for(int i = 0; i < numberOfItemsToProduce; i++){
            batch[i] = new Item();
        }
        warehouse.receiveBatch(batch);

        System.out.println(name + " ended.");
    }

}