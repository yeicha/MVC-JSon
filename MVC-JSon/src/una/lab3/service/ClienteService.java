package una.lab3.service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import una.lab3.model.Cliente;

/**
 *
 * @author Jason
 */
public class ClienteService
{

    public ClienteService()
    {
    }

    public Object[][] loadStudentsObjWrapper() throws JsonGenerationException,
            JsonMappingException, IOException
    {
        Cliente[] clientes = loadStudentsFromFile();
        Object[][] data = null;

        if (clientes != null && clientes.length > 0)
        {
            data = new Object[clientes.length][4]; // filas y columnas
            int i = 0;
            for (Cliente cliente : clientes)
            {
                data[i][0] = checkIfNull(cliente.getName().toString());
                data[i][1] = checkIfNull(cliente.getEmail().toString());
                data[i][2] = checkIfNull(cliente.getFriends().toString());
                data[i][3] = checkIfNull(cliente.getTags().toString());
                i++;
            }
        }

        return data;
    }

    private Cliente[] loadStudentsFromFile() throws JsonGenerationException,
            JsonMappingException, IOException
    {

        Cliente[] clientes = null;
        final String FILENAME = "data.json";

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        clientes = mapper.readValue(new File(FILENAME), Cliente[].class);

        return clientes;
    }

    private String checkIfNull(Object obj)
    {
        String text;
        if (obj == null)
        {
            text = "";
        } else
        {
            text = obj.toString();
        }
        return text;
    }
}
