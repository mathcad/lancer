package pro;

import org.flywaydb.core.internal.license.Edition;
import org.flywaydb.core.internal.license.VersionPrinter;

import java.math.BigInteger;

public enum LicenseType {
    TRIAL((byte)0, VersionPrinter.EDITION, "trial"),
    PRO10((byte)1, Edition.PRO, "10 schemas"),
    PRO20((byte)2, Edition.PRO, "20 schemas"),
    PRO30((byte)3, Edition.PRO, "30 schemas"),
    PRO40((byte)4, Edition.PRO, "40 schemas"),
    PRO50((byte)5, Edition.PRO, "50 schemas"),
    PRO60((byte)6, Edition.PRO, "60 schemas"),
    PRO70((byte)7, Edition.PRO, "70 schemas"),
    PRO80((byte)8, Edition.PRO, "80 schemas"),
    PRO90((byte)9, Edition.PRO, "90 schemas"),
    PRO100((byte)10, Edition.PRO, "100 schemas"),
    PROSITE((byte)15, Edition.PRO, "unlimited schemas"),
    ENTERPRISE10((byte)17, Edition.ENTERPRISE, "10 schemas"),
    ENTERPRISE20((byte)18, Edition.ENTERPRISE, "20 schemas"),
    ENTERPRISE30((byte)19, Edition.ENTERPRISE, "30 schemas"),
    ENTERPRISE40((byte)20, Edition.ENTERPRISE, "40 schemas"),
    ENTERPRISE50((byte)21, Edition.ENTERPRISE, "50 schemas"),
    ENTERPRISE60((byte)22, Edition.ENTERPRISE, "60 schemas"),
    ENTERPRISE70((byte)23, Edition.ENTERPRISE, "70 schemas"),
    ENTERPRISE80((byte)24, Edition.ENTERPRISE, "80 schemas"),
    ENTERPRISE90((byte)25, Edition.ENTERPRISE, "90 schemas"),
    ENTERPRISE100((byte)26, Edition.ENTERPRISE, "100 schemas"),
    ENTERPRISESITE((byte)31, Edition.ENTERPRISE, "unlimited schemas"),
    PRO10_REDISTRIBUTABLE((byte)33, Edition.PRO, "10 schemas, redistributable"),
    PRO20_REDISTRIBUTABLE((byte)34, Edition.PRO, "20 schemas, redistributable"),
    PRO30_REDISTRIBUTABLE((byte)35, Edition.PRO, "30 schemas, redistributable"),
    PRO40_REDISTRIBUTABLE((byte)36, Edition.PRO, "40 schemas, redistributable"),
    PRO50_REDISTRIBUTABLE((byte)37, Edition.PRO, "50 schemas, redistributable"),
    PRO60_REDISTRIBUTABLE((byte)38, Edition.PRO, "60 schemas, redistributable"),
    PRO70_REDISTRIBUTABLE((byte)39, Edition.PRO, "70 schemas, redistributable"),
    PRO80_REDISTRIBUTABLE((byte)40, Edition.PRO, "80 schemas, redistributable"),
    PRO90_REDISTRIBUTABLE((byte)41, Edition.PRO, "90 schemas, redistributable"),
    PRO100_REDISTRIBUTABLE((byte)42, Edition.PRO, "100 schemas, redistributable"),
    PROSITE_REDISTRIBUTABLE((byte)47, Edition.PRO, "unlimited schemas, redistributable"),
    ENTERPRISE10_REDISTRIBUTABLE((byte)49, Edition.ENTERPRISE, "10 schemas, redistributable"),
    ENTERPRISE20_REDISTRIBUTABLE((byte)50, Edition.ENTERPRISE, "20 schemas, redistributable"),
    ENTERPRISE30_REDISTRIBUTABLE((byte)51, Edition.ENTERPRISE, "30 schemas, redistributable"),
    ENTERPRISE40_REDISTRIBUTABLE((byte)52, Edition.ENTERPRISE, "40 schemas, redistributable"),
    ENTERPRISE50_REDISTRIBUTABLE((byte)53, Edition.ENTERPRISE, "50 schemas, redistributable"),
    ENTERPRISE60_REDISTRIBUTABLE((byte)54, Edition.ENTERPRISE, "60 schemas, redistributable"),
    ENTERPRISE70_REDISTRIBUTABLE((byte)55, Edition.ENTERPRISE, "70 schemas, redistributable"),
    ENTERPRISE80_REDISTRIBUTABLE((byte)56, Edition.ENTERPRISE, "80 schemas, redistributable"),
    ENTERPRISE90_REDISTRIBUTABLE((byte)57, Edition.ENTERPRISE, "90 schemas, redistributable"),
    ENTERPRISE100_REDISTRIBUTABLE((byte)58, Edition.ENTERPRISE, "100 schemas, redistributable"),
    ENTERPRISESITE_REDISTRIBUTABLE((byte)63, Edition.ENTERPRISE, "unlimited schemas, redistributable");

    private final byte code;

    private final Edition edition;

    private final String details;

    LicenseType(byte code, Edition edition, String details) {
        this.code = code;
        this.edition = edition;
        this.details = details;
    }

    public byte getCode() {
        return this.code;
    }

    public Edition getEdition() {
        return this.edition;
    }

    public String getDetails() {
        return this.details;
    }

    public static LicenseType fromCode(byte code) {
        for (LicenseType licenseType : values()) {
            if (licenseType.code == code)
                return licenseType;
        }
        throw new IllegalArgumentException("Unknown license code: 0x" + toHex(new byte[] { code }));
    }

    private static String toHex(byte... array) {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = array.length * 2 - hex.length();
        if (paddingLength > 0)
            return String.format("%0" + paddingLength + "d", new Object[] { Integer.valueOf(0) }) + hex;
        return hex;
    }

    public String toString() {
        return this.edition + " (" + this.details + ")";
    }
}
