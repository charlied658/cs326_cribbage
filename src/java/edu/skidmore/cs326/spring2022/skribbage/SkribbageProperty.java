package edu.skidmore.cs326.spring2022.skribbage;

/**
 * Property names used in the Skribbage properties file. Includes convenience
 * getProperty() method to retrieve the value associated with the property.
 * 
 * @see SkribbagePropertiesManager
 * @author readda
 */
public enum SkribbageProperty {
    /**
     * GUI library minimum version property.
     */
    GUI_LIBRARY_MIN_VERSION("GUILibraryMinVersion");

    /**
     * The name of the property used in the properties file.
     */
    private String propertyName;

    /**
     * Set up the enum values.
     * 
     * @param propertyName
     *            The peroperty name used in the properties file
     */
    SkribbageProperty(String propertyName) {
        this.propertyName = propertyName;
    }

    /**
     * Get the property name used in the properties file.
     * 
     * @return The property name
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * Get the value associated with this property.
     * 
     * @see SkribbagePropertiesManager#getProperty(String)
     * @return The property
     */
    public String getPropertyValue() {
        return SkribbagePropertiesManager.getInstance()
            .getProperty(propertyName);
    }

    /**
     * Get the value associated with this property. Return the defaul value if
     * the property is undefined.
     * 
     * @see SkribbagePropertiesManager#getProperty(String, String)
     * @param defaultValue
     *            The default value to return if the property is undefined
     * @return The value associated with the property or the default value if
     *         the property is undefined
     */
    public String getPropertyValue(String defaultValue) {
        return SkribbagePropertiesManager.getInstance().getProperty(
            propertyName,
            defaultValue);
    }
}
