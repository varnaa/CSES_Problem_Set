package StringAlgorithms;

import java.io.*;

import static java.lang.Character.isWhitespace;
import static java.lang.System.in;
import static java.lang.System.out;

public class LongestPalindrome {
  public static void main(String[] args) throws IOException {
    // Task: 1111
    BufferInput input = new BufferInput();
    BufferOutput output = new BufferOutput();

    String s = input.nextString();

    if (s.length() < 2) {
      output.writeString(s);
      output.flush();
      return;
    }

    String result = "";
    for (int i = 0; i < s.length(); i++) {
      String left = reverseString(s, i, i);
      String right = reverseString(s, i, i + 1);

      String max = left.length() > right.length() ? left : right;
      result = max.length() > result.length() ? max : result;
    }

    output.writeString(result);
    output.flush();
  }

  // Expanding algorithm.
  public static String reverseString(String s, int begin, int end) {

    while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
      begin--;
      end++;
    }

    return s.substring(begin + 1, end);
  }
}

class BufferInput {

  /**
   * A constant holding default buffer size, 2<sup>16</sup> bytes of memory.
   */
  private final int BUFFER_SIZE = 1 << 16;

  private DataInputStream din;

  private byte[] buffer;

  private int bufferPointer, bytesRead;

  public BufferInput() {
    din = new DataInputStream(in);
    buffer = new byte[BUFFER_SIZE];
    bufferPointer = bytesRead = 0;
  }

  public BufferInput(String file_name) throws IOException {
    din = new DataInputStream(new FileInputStream(file_name));
    buffer = new byte[BUFFER_SIZE];
    bufferPointer = bytesRead = 0;
  }

  /**
   * Reads the input bytes until it encounters a new line char.
   *
   * @return
   * @throws IOException
   */
  public String readLine() throws IOException {
    byte[] buf = new byte[1000];
    int cnt = 0, c;
    while ((c = read()) != -1) {
      if (c == '\n') break;
      buf[cnt++] = (byte) c;
    }
    return new String(buf, 0, cnt);
  }

  /**
   * @return
   * @throws IOException
   */
  public String nextString() throws IOException {

    // Skip all whitespace characters from the stream
    byte c = read();
    while (isWhitespace(c)) {
      c = read();
    }

    StringBuilder builder = new StringBuilder();
    builder.append((char) c);
    c = read();
    while (!isWhitespace(c)) {
      builder.append((char) c);
      c = read();
    }

    return builder.toString();
  }

  /**
   * Reads an integer value.
   *
   * @return
   * @throws IOException
   */
  public int nextInt() throws IOException {
    int ret = 0;
    byte c = read();
    while (c <= ' ') c = read();
    boolean neg = (c == '-');
    if (neg) c = read();
    do {
      ret = ret * 10 + c - '0';
    } while ((c = read()) >= '0' && c <= '9');

    if (neg) return -ret;
    return ret;
  }

  /**
   * Reads an array of integers.
   *
   * @return
   * @throws IOException
   */
  public int[] nextIntArray(int n) throws IOException {
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = nextInt();
    }
    return arr;
  }

  /**
   * Reads a long value.
   *
   * @return
   * @throws IOException
   */
  public long nextLong() throws IOException {
    long ret = 0;
    byte c = read();
    while (c <= ' ') c = read();
    boolean neg = (c == '-');
    if (neg) c = read();
    do {
      ret = ret * 10 + c - '0';
    } while ((c = read()) >= '0' && c <= '9');
    if (neg) return -ret;
    return ret;
  }

  /**
   * Reads an array of long integers.
   *
   * @return
   * @throws IOException
   */
  public long[] nextLongArray(int n) throws IOException {
    long arr[] = new long[n];
    for (int i = 0; i < n; i++) {
      arr[i] = nextLong();
    }
    return arr;
  }

  /**
   * @return
   * @throws IOException
   */
  public char nextChar() throws IOException {
    byte c = read();
    while (isWhitespace(c)) {
      c = read();
    }
    return (char) c;
  }

  /**
   * Reads a double value.
   *
   * @return
   * @throws IOException
   */
  public double nextDouble() throws IOException {
    double ret = 0, div = 1;
    byte c = read();
    while (c <= ' ') c = read();
    boolean neg = (c == '-');
    if (neg) c = read();

    do {
      ret = ret * 10 + c - '0';
    } while ((c = read()) >= '0' && c <= '9');

    if (c == '.') {
      while ((c = read()) >= '0' && c <= '9') {
        ret += (c - '0') / (div *= 10);
      }
    }

    if (neg) return -ret;
    return ret;
  }

  /**
   * Reads an array of double values.
   *
   * @return
   * @throws IOException
   */
  public double[] nextDoubleArray(int n) throws IOException {
    double arr[] = new double[n];
    for (int i = 0; i < n; i++) {
      arr[i] = nextDouble();
    }
    return arr;
  }

  /**
   * Fills the buffer from input stream.
   *
   * @throws IOException
   */
  private void fillBuffer() throws IOException {
    bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
    if (bytesRead == -1) buffer[0] = -1;
  }

  /**
   * @return
   * @throws IOException
   */
  private byte read() throws IOException {
    if (bufferPointer == bytesRead) fillBuffer();
    return buffer[bufferPointer++];
  }

  public void close() throws IOException {
    if (din == null) return;
    din.close();
  }
}

class BufferOutput {

  /**
   * A constant holding default buffer size, 2<sup>16</sup> bytes of memory.
   */
  private final int BUFFER_SIZE = 1 << 16;
  private DataOutputStream dout;
  private byte[] buffer;

  /**
   * The current position in the buffer for next byte to be written.
   */
  private int pointer = 0;

  /**
   * Creates an instance of {@link BufferOutput} with {@link DataOutputStream} linked to the console
   * output stream.
   */
  public BufferOutput() {
    buffer = new byte[BUFFER_SIZE];
    dout = new DataOutputStream(out);
  }

  /**
   * Creates an instance of {@link BufferOutput} with {@link DataOutputStream} linked to the {@link
   * OutputStream} specified by the out.
   */
  public BufferOutput(OutputStream out) {

    buffer = new byte[BUFFER_SIZE];
    dout = new DataOutputStream(out);
  }

  /**
   * Writes the array of bytes to the buffer.
   *
   * <p>If buffer doesn't have enough space to accommodate the array, the contents of buffer are
   * written to the output stream.
   *
   * @param arr
   * @throws IOException
   */
  public void writeBytes(byte arr[]) throws IOException {

    int bytesToWrite = arr.length;

    if (pointer + bytesToWrite >= BUFFER_SIZE) {
      flush();
    }

    for (int i = 0; i < bytesToWrite; i++) {
      buffer[pointer++] = arr[i];
    }
  }

  /**
   * Writes the string as array of bytes to the buffer.
   *
   * @param str
   * @throws IOException
   */
  public void writeString(String str) throws IOException {
    writeBytes(str.getBytes());
  }

  /**
   * Writes the contents of full buffer to the output stream.
   *
   * @throws IOException
   */
  public void flush() throws IOException {
    dout.write(buffer, 0, pointer);
    dout.flush();
    pointer = 0;
  }

  public void close() throws IOException {
    dout.close();
  }
}
