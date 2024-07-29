package edu.sdccd.cisc191;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * A Warehouse receives, stores and ships Items.
 *
 * Adapted from Tasha Frankie and Allan Schougaard
 */
public class Warehouse
{
    /**
     * storage is managed as one big stack, where items are laid on top of each other
     */
    private ConcurrentLinkedDeque<Item> storage = new ConcurrentLinkedDeque<>();

    public int getNumberOfItemsInStock()
    {
        return storage.size();
    }

    /**
     * Add item to the collection and make the tests pass.
     *
     * @param item the item to store in the Warehouse
     */
    public void receive(Item item)
    {
        System.out.println("Warehouse receive(" + item + ") running in Thread: " + Thread.currentThread().getName());

        storage.push(item);

    }

    /**
     * Remove an item from the collection and make the tests pass
     * @return the item that was retrieved from storage
     * @throws OutOfStockException if there are no items to ship
     */
    public Item ship() throws OutOfStockException
    {
        System.out.println("Warehouse ship() running in Thread: " + Thread.currentThread().getName());


        try {
            return storage.pop();
        }
        catch (NoSuchElementException e) {
            throw new OutOfStockException();
        }

    }

}