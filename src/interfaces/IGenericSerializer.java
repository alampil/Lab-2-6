package interfaces;

import java.util.ArrayList;

public interface IGenericSerializer<T> {
	void serialize(ArrayList<T> dataToSerialize)  throws Exception;
	ArrayList<T> deserialize()throws Exception;
}
