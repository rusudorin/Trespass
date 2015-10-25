import java.lang.reflect.Field;

public class Trespass<T> {

    private T t;
    private Class<T> classType;

    public Trespass(T t, Class<T> classType) {
        this.t = t;
        this.classType = classType;
    }

    /**
     * Used to get the field of a specific object
     * @param variable The name of the variable you want to trespass on
     * @return the filed on which you want to trespass on
     * @throws NoSuchFieldException
     */
    public Field onField(String variable) throws NoSuchFieldException {
        Field field = classType.getDeclaredField(variable);
        field.setAccessible(true);
        return field;
    }

    /**
     * Used to get the variable you specify
     * @param variable The name of the variable
     * @return The object you wish to trespass on
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public Object onVariable(String variable) throws NoSuchFieldException, IllegalAccessException {
        return onField(variable).get(t);
    }

    /**
     * Get the string value of a variable you specify
     * @param variable The name of the variable
     * @return The string value
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public String onString(String variable) throws NoSuchFieldException, IllegalAccessException {
        return (String) onVariable(variable);
    }

    /**
     * Get the integer value of a variable you specify
     * @param variable The name of the variable
     * @return The integer value
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public int onInt(String variable) throws NoSuchFieldException, IllegalAccessException {
        return (int) onVariable(variable);
    }

    /**
     * Get the boolean value of a variable you specify
     * @param variable The name of the variable
     * @return The boolean value
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public boolean onBoolean(String variable) throws NoSuchFieldException, IllegalAccessException {
        return (boolean) onVariable(variable);
    }

}
