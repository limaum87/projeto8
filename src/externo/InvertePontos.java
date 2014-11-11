/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package externo;

/**
 *
 * @author felipe
 */
public class InvertePontos {
    public static String convertePonto(String dotString) {
    StringBuffer outputBuffer = new StringBuffer();

    for (int i = 0; i < dotString.length(); i++) {
      if (dotString.charAt(i) == '.')
        outputBuffer.append('.');
      else if (dotString.charAt(i) == ',')
        outputBuffer.append('.');
      else
        outputBuffer.append(dotString.charAt(i));
    }

    return outputBuffer.toString();
  }
    public static String converteVirgula(String dotString) {
    StringBuffer outputBuffer = new StringBuffer();

    for (int i = 0; i < dotString.length(); i++) {
      if (dotString.charAt(i) == '.')
        outputBuffer.append(',');
      else if (dotString.charAt(i) == ',')
        outputBuffer.append(',');
      else
        outputBuffer.append(dotString.charAt(i));
    }

    return outputBuffer.toString();
  }
}
