package chapter8.command;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MockEditor implements Editor {

    private final List<String> actions = new ArrayList<>();

    @Override
    public void save() {
        actions.add("save");
        System.out.println("Mock save");
    }

    @Override
    public void open() {
        actions.add("open");
        System.out.println("Mock open");
    }

    @Override
    public void close() {
        actions.add("close");
        System.out.println("Mock close");
    }
    
    public void check() {
        assertEquals("open", actions.get(0));
        assertEquals("save", actions.get(1));
        assertEquals("close", actions.get(2));
    }

}
