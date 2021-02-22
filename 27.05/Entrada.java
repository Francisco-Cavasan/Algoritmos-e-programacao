import javax.swing.*;

/**
 * Class Entrada - input class for input of simple input types
 * via simple dialog box.
 * eg. int, char, String, double or boolean.
 *
 * @author Bruce Quig
 * @author Michael Kolling
 * @author Eugene Ageenko
 * @author Marcelo de G. Malheiros
 * @author Jonas A. Dhein
 *
 * @version 1.3
 * Modified (Aug 12, 2003): Portuguese version, added methods without parameters.
 */

public class Entrada {
    // instance variables
    static final String STRING_TITLE = "Entre com uma string";
    static final String CHAR_TITLE = "Entre com um char";
    static final String INT_TITLE = "Entre com um int";
    static final String BOOLEAN_TITLE = "Selecione verdadeiro ou falso";
    static final String OPTION_TITLE = "Selecione uma opção";
    static final String DOUBLE_TITLE = "Entre com um double";
    static final String TRUE = "true";
    static final String FALSE = "false";
    static final String EMPTY_STRING = "";

    /**
     *  No constructor by default.
     */
    private Entrada() {
    }

    /**
     ** String input from the user via a simple dialog.
     ** @return String input from the user.
     **/
    public static String leiaString() {
        return leiaString("","");
    }
    
    public static void mostraTexto(String titulo, String descricao){
      JOptionPane.showMessageDialog(null, descricao, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     ** String input from the user via a simple dialog.
     ** @param prompt the message string to be displayed inside dialog
     ** @return String input from the user.
     **/
    public static String leiaString(String prompt) {
        return leiaString(prompt,"");
    }

    /**
     ** String input from the user via a simple dialog.
     ** @param prompt the message string to be displayed inside dialog
     ** @param initialValue input string that is initially displayed as selected by the user
     ** @return String input from the user.
     **/
    public static String leiaString(String prompt, String initialValue) {
        Object[] commentArray = {prompt, EMPTY_STRING, EMPTY_STRING};
        Object[] options = {"OK"};

        boolean validResponse = false;

        String result = null;

        while (!validResponse) {
            final JOptionPane optionPane = new JOptionPane(commentArray,
                                                           JOptionPane.QUESTION_MESSAGE,
                                                           JOptionPane.OK_CANCEL_OPTION,
                                                           null,
                                                           options,
                                                           options[0]);

            optionPane.setWantsInput(true);
            optionPane.setInitialSelectionValue(initialValue);  // EA: added
            JDialog dialog = optionPane.createDialog(null, STRING_TITLE);

            dialog.pack();
            dialog.setVisible(true);

            Object response = optionPane.getInputValue();

            if (response != JOptionPane.UNINITIALIZED_VALUE) {
                result = (String) response;
                if (result != null) // EA: added for completnes
                    validResponse = true;
                else {
                    commentArray[1] = "Entrada inválida: ";
                    commentArray[2] = "Entre com uma string válida";
                }
            } else {
                commentArray[1] = "Precisa entrar com uma string";
                commentArray[2] = EMPTY_STRING;
            }
        }
        return result;
    }

    /**
     ** returns character input from the user via a simple dialog.
     ** @return the input character
     **/
    public static char leiaChar() {
        return leiaChar("","");
    }

    /**
     ** returns character input from the user via a simple dialog.
     ** @param prompt the message string to be displayed inside dialog
     ** @return the input character
     **/
    public static char leiaChar(String prompt) {
        return leiaChar(prompt,"");
    }

    /**
     ** returns character input from the user via a simple dialog.
     ** @param prompt the message string to be displayed inside dialog
     ** @param initialValue input value that is initially displayed as selected by the user
     ** @return the input character
     **/
    public static char leiaChar(String prompt, char initialValue) {
        return leiaChar(prompt,Character.toString(initialValue));
    }

    /**
     ** returns character input from the user via a simple dialog.
     ** @param prompt the message string to be displayed inside dialog
     ** @param initialValue input string that is initially displayed as selected by the user
     ** @return the input character
     **/
    public static char leiaChar(String prompt, String initialValue) {
        char response = (initialValue != null && initialValue.length() > 0) ? initialValue.charAt(0) : '-'; // EA: modified

        String result = null;

        Object[] commentArray = {prompt, EMPTY_STRING, EMPTY_STRING};
        Object[] options = {"OK"};

        boolean validResponse = false;

        while (!validResponse) {
            final JOptionPane optionPane = new JOptionPane(commentArray,
                                                           JOptionPane.QUESTION_MESSAGE,
                                                           JOptionPane.OK_CANCEL_OPTION,
                                                           null,
                                                           options,
                                                           options[0]);

            optionPane.setWantsInput(true);
            optionPane.setInitialSelectionValue(initialValue);  // EA: added
            JDialog dialog = optionPane.createDialog(null, CHAR_TITLE);

            dialog.pack();
            dialog.setVisible(true);

            result = null; // EA: added for convinience;
            // EA: why character processed in another way that integer?
            // EA: meaning that with check for uinitialized case then assignment?

            Object input = optionPane.getInputValue();
            if (input != JOptionPane.UNINITIALIZED_VALUE) {
                result = (String) input;
                if (result != null) {
                    if (result.length() == 1) {
                        response = result.charAt(0);
                        validResponse = true;
                    } else {
                        commentArray[1] = "Entrada inválida: " + result;
                        commentArray[2] = "Entre com apenas um caracter";
                    }
                } else {
                    commentArray[1] = "Entrada inv�lida"; // EA: corrected, no point to print null-object. Question: when it is possible to have null objects?
                    commentArray[2] = "Entre com apenas um caracter";
                }
            } else {
                commentArray[1] = "Precisa entrar com apenas um caracter";  //EA: error corrected, result removed
                commentArray[2] = EMPTY_STRING; //EA: cannot use result since it is not initialized
            }
        }
        return response;
    }

    /**
     ** boolean selection from the user via a simple dialog.
     ** @return boolean selection from the user
     **/
    public static boolean leiaBoolean() {
        return leiaBoolean("", TRUE, FALSE);
    }

    /**
     ** boolean selection from the user via a simple dialog.
     ** @param  prompt message to appear in dialog
     ** @return boolean selection from the user
     **/
    public static boolean leiaBoolean(String prompt) {
        return leiaBoolean(prompt, TRUE, FALSE);
    }

    /**
     ** boolean selection from the user via a simple dialog.
     ** @param  prompt message to appear in dialog
     ** @param  trueText message to appear on true "button"
     ** @param  falseText message to appear on "false" button
     ** @return boolean selection from the user
     **/
    public static boolean leiaBoolean(String prompt, String trueText, String falseText) {
        Object[] commentArray = {prompt, EMPTY_STRING};
        boolean validResponse = false;
        int result = -1;

        while (!validResponse) {
            Object[] options = {trueText, falseText};
            result = JOptionPane.showOptionDialog(null,
                                                  commentArray,
                                                  "Escolha uma opção",
                                                  JOptionPane.YES_NO_OPTION,
                                                  JOptionPane.QUESTION_MESSAGE,
                                                  null, //don't use a custom Icon
                                                  options, //the titles of buttons
                                                  trueText); //the title of the default button, EA: CORRECTED from TRUE

            // check true or false buttons pressed
            if (result == JOptionPane.YES_OPTION || result == JOptionPane.NO_OPTION) // CORRECTED from 0:1
            {
                validResponse = true;
            } else {
                commentArray[1] = "Seleção incorreta: escolha os botões true ou false";
            }
        }
        return (result == 0);
    }
    
    public static int leiaOpcao(String prompt, String option1, String option2, String option3) {
        Object[] commentArray = {prompt, EMPTY_STRING};
        boolean validResponse = false;
        int result = -1;

        while (!validResponse) {
            Object[] options = {option3, option2, option1};
            result = JOptionPane.showOptionDialog(null,
                                                  commentArray,
                                                  OPTION_TITLE,
                                                  JOptionPane.DEFAULT_OPTION,
                                                  JOptionPane.QUESTION_MESSAGE,
                                                  null, //don't use a custom Icon
                                                  options, //the titles of buttons
                                                  "OPÇÃO"); //the title of the default button, EA: CORRECTED from TRUE

            validResponse = true;
            if(result == 0){
              return 3;
            }else if(result == 1){
              return 2;
            }else if(result == 2){
              return 1;
            }
        }
        return -1;
    }
    
    public static int leiaOpcao(String prompt, String option1, String option2, String option3, String option4) {
        Object[] commentArray = {prompt, EMPTY_STRING};
        boolean validResponse = false;
        int result = -1;

        while (!validResponse) {
            Object[] options = {option4, option3, option2, option1};
            result = JOptionPane.showOptionDialog(null,
                                                  commentArray,
                                                  OPTION_TITLE,
                                                  JOptionPane.DEFAULT_OPTION,
                                                  JOptionPane.QUESTION_MESSAGE,
                                                  null, //don't use a custom Icon
                                                  options, //the titles of buttons
                                                  "OPÇÃO"); //the title of the default button, EA: CORRECTED from TRUE

            validResponse = true;
            validResponse = true;
            if(result == 0){
              return 4;
            }else if(result == 1){
              return 3;
            }else if(result == 2){
              return 2;
            }else if(result == 3){
              return 1;
            }
            //response = result.getValue();
            /*System.out.println(result);
            // check true or false buttons pressed
            if (result == JOptionPane.YES_OPTION){
                validResponse = true;
                response = 3;
            }else if(result == JOptionPane.NO_OPTION){
              validResponse = true;
                response = 2;
            }else if(result == JOptionPane.CANCEL_OPTION){
              validResponse = true;
                response = 1;
            } else {
                commentArray[1] = "Seleção incorreta: escolha uma opção da tela";
            }*/
        }
        return -1;
    }

    /**
     ** returns integer input from the user via a simple dialog.
     ** @return the input integer
     */
    public static int leiaInt() {
        return leiaInt("","");
    }

    /**
     ** returns integer input from the user via a simple dialog.
     ** @param prompt the message string to be displayed inside dialog
     ** @return the input integer
     */
    public static int leiaInt(String prompt) {
        return leiaInt(prompt,"");
    }

    /**
     ** returns integer input from the user via a simple dialog.
     ** @param prompt the message string to be displayed inside dialog
     ** @param initialValue input value that is initially displayed as selected by the user
     ** @return the input integer
     **/
    public static int leiaInt(String prompt, int initialValue) {
        return leiaInt(prompt,Integer.toString(initialValue));
    }

    /**
     ** returns integer input from the user via a simple dialog.
     ** @param prompt the message string to be displayed inside dialog
     ** @param initialValue input string that is initially displayed as selected by the user
     ** @return the input integer
     **/
    public static int leiaInt(String prompt, String initialValue) {
        Object[] commentArray = {prompt, EMPTY_STRING, EMPTY_STRING};
        Object[] options = {"OK"};

        boolean validResponse = false;

        int response = 0;
        while (!validResponse) {
            final JOptionPane optionPane = new JOptionPane(commentArray,
                                                           JOptionPane.QUESTION_MESSAGE,
                                                           JOptionPane.OK_CANCEL_OPTION,
                                                           null,
                                                           options,
                                                           options[0]);

            optionPane.setWantsInput(true);
            optionPane.setInitialSelectionValue(initialValue);  // EA: added
            JDialog dialog = optionPane.createDialog(null, INT_TITLE);

            dialog.pack();
            dialog.setVisible(true);

            // EA: rewritten as in leiaChar function
            // EA: added or corrected non-portable check for uninitialized value situation
            Object input = optionPane.getInputValue();
            if (input == JOptionPane.UNINITIALIZED_VALUE) {
                commentArray[1] = "Precisa entrar com um valor inteiro"; // EA: explanatory text added
                commentArray[2] = EMPTY_STRING;
            } else {
                String result = (String) input;
                if (result == null) { // EA: added for completnes, but is this situation possible?
                    commentArray[1] = "Valor inteiro inválido:";
                    commentArray[2] = "Entre com um valor inteiro válido";
                } else {
                    try {
                        //workaround for BlueJ bug - misses first exception after compilation
                        //response = Integer.parseInt(result); // EA: ?
                        response = Integer.parseInt(result);
                        validResponse = true;
                    } catch (NumberFormatException exception) {
                        commentArray[1] = "Valor inteiro inválido: " + result;
                        commentArray[2] = "Entre com um valor inteiro válido";
                        initialValue = result; // EA: added
                    }
                }
            }
        }
        return response;
    }

    /**
     ** returns double input from the user via a simple dialog.
     ** @return the input double
     **/
    public static double leiaDouble() {
        return leiaDouble("","");
    }

    /**
     ** returns double input from the user via a simple dialog.
     ** @param prompt the message string to be displayed inside dialog
     ** @return the input double
     **/
    public static double leiaDouble(String prompt) {
        return leiaDouble(prompt,"");
    }

    /**
     ** returns double input from the user via a simple dialog.
     ** @param prompt the message string to be displayed inside dialog
     ** @param initialValue input value that is initially displayed as selected by the user
     ** @return the input double
     **/
    public static double leiaDouble(String prompt, double initialValue) {
        return leiaDouble(prompt,Double.toString(initialValue));
    }

    /**
     ** returns double input from the user via a simple dialog.
     ** @param prompt the message string to be displayed inside dialog
     ** @param initialValue input string that is initially displayed as selected by the user
     ** @return the input double
     **/
    public static double leiaDouble(String prompt, String initialValue) {
        Object[] options = {"OK"};
        Object[] commentArray = {prompt, EMPTY_STRING, EMPTY_STRING};

        boolean validResponse = false;

        double response = 0.0;

        while (!validResponse) {
            final JOptionPane optionPane = new JOptionPane(commentArray,
                                                           JOptionPane.QUESTION_MESSAGE,
                                                           JOptionPane.OK_CANCEL_OPTION,
                                                           null,
                                                           options,
                                                           options[0]);

            optionPane.setWantsInput(true);
            optionPane.setInitialSelectionValue(initialValue);  // EA: added
            JDialog dialog = optionPane.createDialog(null, DOUBLE_TITLE);

            dialog.pack();
            dialog.setVisible(true);

            Object input = optionPane.getInputValue();
            if (input == JOptionPane.UNINITIALIZED_VALUE) {
                commentArray[1] = "Precisa entrar com um valor fracionário"; // EA: explanatory text added
                commentArray[2] = EMPTY_STRING;
            } else {
                String result = (String) input;
                if (result == null) { // EA: added for completnes, but is this situation possible?
                    commentArray[1] = "valor fracionário inválido:";
                    commentArray[2] = "Entre com um valor fracionário válido";
                } else {
                    // convert String to double
                    try {
                        // workaround for BlueJ bug - misses first exception after recompilation?
                        response = Double.valueOf(result).doubleValue();
                        response = Double.valueOf(result).doubleValue();
                        validResponse = true;
                    } catch (NumberFormatException exception) {
                        // EA: case with uninitialized value is moved up
                        commentArray[1] = "Valor fracionário inválido: " + result;
                        commentArray[2] = "Entre com um valor fracionário válido";
                        initialValue = result;    // EA: corrected
                    }
                }
            }
        }
        return response;
    }
}