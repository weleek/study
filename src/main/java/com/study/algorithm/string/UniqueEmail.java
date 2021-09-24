package com.study.algorithm.string;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmail {
    /**
     * 모든 유효한 이메일은@을 기준으로 로컬이름과 도메인이름으로 구성됩니다.
     * 또한 소문자외에 하나 이상의 '.'또는 '+’을 포함합니다.
     *
     * 예) test@coding.com
     * test는 로컬이름이고 codingtest.com은 도메인 이름입니다.
     * 이메일에는 소문자 외에 '.'또는 '+'가 포함될 수 있습니다.
     *
     * 로컬이름에 일부 문자 사이에 마침표 ( '.')를 추가하여
     * 전송된 메일은 로컬 이름에 점이없는 동일한 주소로 전달됩니다.
     * 예) test.email@codingtest.com 및 testemail@codingtest.com 은 동일한 이메일 주소로 전달됩니다.
     * (이 규칙은 도메인 이름에는 적용되지 않습니다.)
     *
     * 로컬 이름에 더하기 ( '+')를 추가하면 첫 번째 더하기 기호 뒤의 모든 항목이 무시됩니다.
     * 이를 통해 특정 이메일을 필터링 할 수 있습니다.
     * 예) test.email+james@codingtest.com은  test.email@codingtest.com으로 전달됩니다.
     * (이 규칙은 도메인 이름에는 적용되지 않습니다.)
     * 이 두 규칙을 동시에 사용할 수 있습니다.
     *
     * 이메일 목록이 주어지면 목록의 각 주소로 하나의 이메일을 보냅니다.
     * 실제로 메일을받는 주소는 몇 개입니까?
     */

    public int solution(String[] emails) {
        Set<String> result = new HashSet<>();

        for (String email: emails) {
            String localName = makeLocalName(email);
            String domain = makeDomain(email);
            result.add(localName + domain);
        }

        return result.size();
    }

    private String makeDomain(String email) {
        return email.substring(email.indexOf("@"));
    }

    private String makeLocalName(String email){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<email.length(); i++) {
            if (email.charAt(i) == '.') {
                continue;
            }

            if (email.charAt(i) == '+' || email.charAt(i) == '@') {
                break;
            }
            stringBuilder.append(email.charAt(i));
        }
        return stringBuilder.toString();
    }
}
