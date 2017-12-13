package methodsJson;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import interfaces.IGenericSerializer;


public class GenericProviderJson<T> implements IGenericSerializer<T> {

	private static File fileName;
	private ObjectMapper mapper;
	private Class<T> clases;

	public Class<T> getClases() {
		return clases;
	}

	public void setClases(Class<T> clases) {
		this.clases = clases;
	}

	public GenericProviderJson(File filePath) {
		fileName = filePath;
		mapper = new ObjectMapper();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		mapper.setDateFormat(sdf);
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
	}

	@Override
	public void serialize(ArrayList<T> dataToSerialize) throws Exception {
		mapper.writeValue(fileName, dataToSerialize);

	}

	@Override
	public ArrayList<T> deserialize() throws Exception {
		TypeFactory typeFactory = mapper.getTypeFactory();
		CollectionType collectionType = typeFactory.constructCollectionType(ArrayList.class, clases);
		return mapper.readValue(fileName, collectionType);
	}

}


