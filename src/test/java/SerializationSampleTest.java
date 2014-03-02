import junit.framework.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationSampleTest {

    @Test
    public void canTestSerialization() throws IOException, ClassNotFoundException {
        SerializableSample sample = new SerializableSample();
        sample.setStr("blahhh");


        FileOutputStream fs = new FileOutputStream("test.txt");
        ObjectOutputStream os = new ObjectOutputStream(fs);
        os.writeObject(sample);

        FileInputStream fileInputStream = new FileInputStream("test.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        SerializableSample sampleRetrieved = (SerializableSample) objectInputStream.readObject();

        Assert.assertEquals(sample.getStr(), sampleRetrieved.getStr());
    }
}
