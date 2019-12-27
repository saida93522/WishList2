import javax.swing.*;
import java.awt.desktop.UserSessionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PlaceGui extends JFrame{
    private JLabel PlaceLabel;
    private JTextField PlacetextField1;
    private JTextField ReasontextField2;
    private JList<Place>placeList;
    private JButton addButton;
    private JButton deleteButton;
    private JButton clearAllListButton;
    private JButton updateButton;
    private JPanel mainPanel;

    private Controller connect;

    private DefaultListModel<Place> placeListModel;


    PlaceGui(Controller connect){
        this.connect = connect;

        placeListModel = new DefaultListModel<>();
        placeList.setModel(placeListModel);

        addListener();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setVisible(true);

    }

    private void errorDialog(String msg){
        JOptionPane.showMessageDialog(PlaceGui.this,msg,"Error",JOptionPane.ERROR_MESSAGE);
    }

    private void addListener() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String place = PlacetextField1.getText();

                if (place.isEmpty()){
                    errorDialog("Please Enter a place Name");
                    return;
                }
                return Reason;
            }
        });

    }

    void setListData(List<Place> data){
        placeListModel.clear();

        if (data !=null){
            for (Place place: data){
                placeListModel.addElement(place);

            }
        }
    }
}
