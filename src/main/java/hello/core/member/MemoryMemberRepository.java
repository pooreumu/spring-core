package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    /**
     * 동시성 이슈가 있을 수 있어서 HashMap대신 ConcurrentHashMap을 쓰는게 좋은데 그럼 강의가 길어지니까 간단하게 HashMap사용하고 넘어감
     */

    private static final Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
