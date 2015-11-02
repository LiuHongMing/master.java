package javat.access;

import javat.AccessTest;

public class ChildAccess extends AccessTest {

    public ChildAccess() {
        System.out.println("ChocolateChip construction");
    }

    public void doAccess() {
        // error, the method bite() from the type Cookie is not visible
        // access();
    }

}
