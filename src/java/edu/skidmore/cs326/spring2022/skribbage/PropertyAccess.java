package edu.skidmore.cs326.spring2022.skribbage;

/**
 * Runtime property access.
 * 
 * @author readda
 */
public interface PropertyAccess {
    /**
     * Get the value associated with a property name. Null is returned if the
     * property name is undefined.
     * 
     * @param propertyName
     *            The name of the property
     * @return The value associated with the property or null if underfined
     */
    String getProperty(String propertyName);

    /**
     * Get the value associated with a property name. The default value is
     * returned if the value is undefined.
     * 
     * @param propertyName
     *            The name of the property
     * @param defaultValue
     *            The default value to use of the property is undefined
     * @return The value associated with the property or the default value if
     *         the property is undefined
     */
    String getProperty(String propertyName, String defaultValue);

    /**
     * Get the number of properties defined.
     * 
     * @return The number of properties
     */
    int getNumProperties();

    /**
     * Set the value for a property. If the property was previously defined, its
     * value is replaced.
     * 
     * @param propertyName
     *            The name of the property
     * @param value
     *            The value associated with the property
     */
    void setProperty(String propertyName, String value);
}
