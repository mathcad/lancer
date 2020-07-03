package pro;

import org.flywaydb.core.api.FlywayException;
import org.flywaydb.core.internal.util.DateUtils;

import javax.crypto.Cipher;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;

public class LicenseInfo {
    private static final String DECRYPTION_KEY = "30820122300d06092a864886f70d01010105000382010f003082010a02820101009fbebb4eb38e68c758ff04f2ca68f6c37660eb5b821aabbfac7c221c54debec144edacc9f95005f8070f0ee20fc54c8e913ae859e2a96864ebe7d153a092e12379cfae26ba615f778db674452d0466c4259faadce1772b3e4b71f4a63c8c6856e093e9e279c9f0834b986606e223c691cfddba18e5cfc54d0f50f1c44eeafefaad2e805edd67946d69902a0fe1d119e7814a5add199ba95ffa9e2318240040219a96ba1f3a55a96359d2c590b3050f77f5b9950d04f3e77aa891578e0800fb16e4d122bcdd3f422cb846f982a5177b803d3fbfd45b4c61d6182ca429b85c77bed678fd345bcbae01c51aef2ecf0bd1c3f85aeebe60380933501cf0b98eca97670203010001";
//    private static final String publicKey = "30819F300D06092A864886F70D010101050003818D00308189028181009F2224EB1D031167009138300605966CCDB34F5152206E77B9791AB49BD21CBF6E13DECA97C24B8366B9B558DDCAC5D3CB0554556E60EA78C13C2FBC4BB161779A24DD32C6AF284765CFC55697E141E6C0FE13550921781E3B7174EEC7FEB603D5B04570959503D3D799EB97018BF67FA60C07F4554B9D906566AFA1A69902690203010001";
//    private static final String privateKey = "30820277020100300D06092A864886F70D0101010500048202613082025D020100028181009F2224EB1D031167009138300605966CCDB34F5152206E77B9791AB49BD21CBF6E13DECA97C24B8366B9B558DDCAC5D3CB0554556E60EA78C13C2FBC4BB161779A24DD32C6AF284765CFC55697E141E6C0FE13550921781E3B7174EEC7FEB603D5B04570959503D3D799EB97018BF67FA60C07F4554B9D906566AFA1A69902690203010001028180519B88054EDE88E922C05669425D5134411528A31293F132D2DA0958FFE3F3BC342E5A7DD8EFDA1BEBED66D3C902390B913D0D6FB6685B364C1A9A7C5CF0FD832FEF45FA0AA791BF89988E121E06238F76F34E63CD42726D7C3C001689D612A8EE7022D09FEF847876FAE4CC1F2663B7A96CC048539DDF89EC6DC80C768C3475024100EBE0D995DFA8DBC3AC38C1E3D8A0785064EF03644B59BDD937C2FF23BDC4FDC4B2595D4B7264391938B634C891D971579C4ECCD22FC51A18047A2FAC8B597EFF024100ACB5534CB4ADDCC3BE480139FFE97246CFB1C24AB36B4E2399E48DBCA4F5D73D7DF5607139C42D8B6832589D46CC388F33A31F431D1F5324514BC50CA94AE697024044B5406C29B4341FB140EF2981666CE56E213929B3D1363DD9C251338609A5A9F0119BDD683ACD6F0D57F5D41EB7EA0E0D17DF0DB2A085534DAA91CC7EE2D8DD0241009527780C3BD21761B978880EA613DF8C861C97965A03671559F7C7ECCE6E3E782DCAF78271881A6956107CF53F4A69E24A8F2B1594161480BDF0F8F9A94F357B02410080803EC1339AC7272C875B1E182289A2BF287B4B4AB47CA6B456702808362D0C3AE33BB6DFC13FC8F10748F5BE45E266F4B8BBDA70B1CEAC57E546EA8D1CB7B0";


    private final LicenseType licenseType;

    private final String licensedTo;

    private final Date validUntil;

    public LicenseInfo(String licenseKey) {
//        if (!StringUtils.hasLength(licenseKey))
//            throw new FlywayException("Missing license key. Ensure flyway.licenseKey is set to a valid Flyway license key (\"FL01\" followed by 512 hex chars)");
//        if (!licenseKey.matches("FL01[A-F0-9]{512}"))
//            throw new FlywayException("Invalid license key. Ensure flyway.licenseKey is set to a valid Flyway license key (\"FL01\" followed by 512 hex chars)");
//        byte[] decrypted = rsaDecrypt(fromHex(licenseKey.substring(4)), rsaPublicKey(fromHex("30820122300d06092a864886f70d01010105000382010f003082010a02820101009fbebb4eb38e68c758ff04f2ca68f6c37660eb5b821aabbfac7c221c54debec144edacc9f95005f8070f0ee20fc54c8e913ae859e2a96864ebe7d153a092e12379cfae26ba615f778db674452d0466c4259faadce1772b3e4b71f4a63c8c6856e093e9e279c9f0834b986606e223c691cfddba18e5cfc54d0f50f1c44eeafefaad2e805edd67946d69902a0fe1d119e7814a5add199ba95ffa9e2318240040219a96ba1f3a55a96359d2c590b3050f77f5b9950d04f3e77aa891578e0800fb16e4d122bcdd3f422cb846f982a5177b803d3fbfd45b4c61d6182ca429b85c77bed678fd345bcbae01c51aef2ecf0bd1c3f85aeebe60380933501cf0b98eca97670203010001")));
//        this.licenseType = LicenseType.fromCode(decrypted[0]);
//        int year = 2000 + decrypted[1];
//        int month = decrypted[2];
//        int day = decrypted[3];
//        this.validUntil = DateUtils.toDate(year, month, day);
//        try {
//            this.licensedTo = new String(Arrays.copyOfRange(decrypted, 4, decrypted.length), "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            throw new FlywayException("Invalid license encoding", e);
//        }
        licenseType = LicenseType.ENTERPRISESITE_REDISTRIBUTABLE;
        licensedTo = "Everyone";
        validUntil = DateUtils.toDate(2030, 12, 31);
    }

    public LicenseType getLicenseType() {
        return this.licenseType;
    }

    public String getLicensedTo() {
        return this.licensedTo;
    }

    public Date getValidUntil() {
        return this.validUntil;
    }

    private PublicKey rsaPublicKey(byte[] publicKey) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(publicKey));
        } catch (GeneralSecurityException e) {
            throw new FlywayException("Unable to load the license decryption key", e);
        }
    }

    private byte[] rsaDecrypt(byte[] encrypted, Key key) {
        try {
            Cipher rsa = Cipher.getInstance("RSA/ECB/Pkcs1Padding");
            rsa.init(2, key);
            return rsa.doFinal(encrypted);
        } catch (GeneralSecurityException e) {
            throw new FlywayException("Unable to decrypt license", e);
        }
    }

    public static byte[] fromHex(String hex) {
        byte[] binary = new byte[hex.length() / 2];
        for (int i = 0; i < binary.length; i++)
            binary[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        return binary;
    }
}
