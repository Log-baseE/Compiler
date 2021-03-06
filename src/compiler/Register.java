package compiler;

public enum Register implements Operand {
  R0, R1, R2, R3, R4, R5, R6, R7, R8,
  R9, R10, R11, R12, R13, R14, R15;

  public String getCode() {
    return Integer.toHexString(ordinal());
  }

  public static int isRegister(String value) {
    try {
      return valueOf(value.toUpperCase()).ordinal();
    } catch (Exception e) {
      return -1;
    }
  }

  public static boolean isReserved(Register register) {
    return register == R12 || register == R13 || register == R14 || register == R15;
  }

  public static Register getRegister(int id) {
    return values()[id];
  }

  public static Register getValue(String s) {
    return valueOf(s.toUpperCase());
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
