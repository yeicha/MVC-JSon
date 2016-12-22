package una.lab3.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import una.lab3.patterns.Constants;
import una.lab3.service.ClienteService;

/**
 *
 * @author Jason
 */
public class ClienteController implements KeyListener, ActionListener
{

    private JTextField textodebusqueda = new JTextField(26);
    private DefaultTableModel tableModel;
    private ClienteService clienteService;
    private Object[][] clientes;

    public ClienteController(JTextField textodebusqueda,
            DefaultTableModel tableModel) throws JsonMappingException, IOException
    {
        super();
        clienteService = new ClienteService();
        clientes = clienteService.loadStudentsObjWrapper();

        this.textodebusqueda = textodebusqueda;
        this.tableModel = tableModel;

        tableModel.setDataVector(clientes, Constants.TABLE_HEADER);
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        String searchTerm = textodebusqueda.getText();

        //Method to search items
        updateTableSearchTerms(searchTerm);
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String searchTerm = textodebusqueda.getText();

        //Method to search items
        updateTableSearchTerms(searchTerm);
    }

    private void updateTableSearchTerms(String searchTerm)
    {
        if (searchTerm != null && !"".equals(searchTerm)
                && clientes != null && clientes.length > 1)
        {
            Object[][] newData = new Object[clientes.length][];
            int idx = 0;
            for (Object[] obj : clientes)
            {
                String fullText = obj[0].toString() + obj[1].toString()
                        + obj[2].toString() + obj[3].toString();

                if (fullText.contains(searchTerm.trim()))
                {
                    newData[idx++] = obj;
                }
            }
            tableModel.setDataVector(newData, Constants.TABLE_HEADER);
        } else
        {
            /* JOptionPane.showMessageDialog(null,
                    "Search term is empty", "Error",
                    JOptionPane.ERROR_MESSAGE);
            tableModel.setDataVector(clientes, Constants.TABLE_HEADER);*/
        }
    }
}
