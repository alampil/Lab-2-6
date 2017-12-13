package interfaces;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import methods.GenericFile;
import parsers.LocalDateAdapter;

public class GenericProviderXml<T> implements IGenericSerializer<T> {
	private static File fileName;
	private static GenericFile file;
	private static XStream xStream;

	public GenericProviderXml(File filePath) {
		fileName = filePath;
		file = new GenericFile();
		xStream = new XStream(new DomDriver());
		xStream.autodetectAnnotations(true);
		xStream.registerConverter(new LocalDateAdapter());
	}

	@Override
	public void serialize(ArrayList<T> dataToSerialize) throws IOException {
		String studentsString = xStream.toXML(dataToSerialize);
		file.write(studentsString, fileName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<T> deserialize() throws Exception {
		return (ArrayList<T>) xStream.fromXML(file.read(fileName));
	}
}


