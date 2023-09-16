package DesignObjects;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;

import Objects.Room.RoomType;

/**
 * A customized JComboBox for selecting room types and capacities.
 * 
 * @Author ManuelVillotti
 */
public class RoomTypeComboBox extends JComboBox<String> {

    /**
     * Initializes a new instance of the RoomTypeComboBox class.
     * Sets up the model, default selection, and custom renderer.
     */
    public RoomTypeComboBox() {
        super();
        setModel();
        super.setSelectedIndex(0);
        super.setRenderer(new CustomListCellRenderer());
    }

    /**
     * Custom list cell renderer for displaying room types and capacities.
     */
    private class CustomListCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(javax.swing.JList<?> list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
            // Custom rendering logic
            String displayText = "null";

            if (value instanceof String) {
                displayText = (String) value;
            } else if (value instanceof ArrayList) {
                @SuppressWarnings("unchecked")
                RoomType roomType = (RoomType) ((ArrayList<RoomType>) value).get(0);
                @SuppressWarnings("unchecked")
                int capacity = (int) ((ArrayList<Integer>) value).get(1);
                if (roomType == RoomType.STANDARD) {
                    if (capacity == 1)
                        displayText = "Single room standard";
                    else
                        displayText = "Double room standard";
                }
                if (roomType == RoomType.DELUXE) {
                    if (capacity == 1)
                        displayText = "Single room deluxe";
                    else
                        displayText = "Double room deluxe";
                }
                if (roomType == RoomType.KING) {
                    displayText = "King suite";
                }
            }

            // Return the customized component
            return super.getListCellRendererComponent(list, displayText, index, isSelected, cellHasFocus);
        }
    }

    /**
     * Gets the selected item as an ArrayList containing RoomType at index 0 and
     * capacity at index 1.
     * 
     * @return An ArrayList containing the selected RoomType and capacity.
     */
    public ArrayList<Object> getSelectedItem() {
        ArrayList<Object> result = new ArrayList<>();
        if (super.getSelectedItem().equals("Single room standard")) {
            result.add(RoomType.STANDARD);
            result.add(1);
        } else if (super.getSelectedItem().equals("Double room standard")) {
            result.add(RoomType.STANDARD);
            result.add(2);
        } else if (super.getSelectedItem().equals("Single room deluxe")) {
            result.add(RoomType.DELUXE);
            result.add(1);
        } else if (super.getSelectedItem().equals("Double room deluxe")) {
            result.add(RoomType.DELUXE);
            result.add(2);
        } else if (super.getSelectedItem().equals("King suite")) {
            result.add(RoomType.KING);
            result.add(2);
        } else {
            result.add(super.getSelectedItem());
        }
        return result;
    }

    /**
     * Sets up the model with room type options.
     */
    private void setModel() {
        super.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "Single room standard", "Double room standard", "Single room deluxe",
                        "Double room deluxe", "King suite" }));
    }
}
