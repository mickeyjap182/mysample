package practice.basicfeature.novice.interfaces.impl;

import practice.basicfeature.novice.interfaces.MarkerInterface;

import java.io.*;

public class MakerIfSample implements MarkerInterface , Serializable , Externalizable {

    private boolean writeExternal = false;
    private boolean readExternal = false;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        writeExternal = true;
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        readExternal = true;
    }
    public boolean isCalledWriteExternal() {
        return writeExternal;
    }
    public boolean isCalledReadExternal() {
        return readExternal;
    }

}
