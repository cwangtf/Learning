package jiagou;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author xing_seng
 * @date 2020/8/23
 */
public class checkPW {
    public boolean checkPW(String userId, String inputPw, String dbPw) {
        String pwMd5 = DigestUtils.md5Hex(userId + inputPw);
        return pwMd5.equals(dbPw);
    }
}
