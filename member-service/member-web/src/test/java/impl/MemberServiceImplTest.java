package impl;

import com.cfd.member.service.MemberService;
import com.cfd.pojo.dto.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

/**
 * @auth snifferhu
 * @date 2018/7/15 17:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberServiceImplTest {

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();;
    @Autowired
    private MemberService memberService;

    @Test
    public void insert() throws Exception {
        Member member = Member.createUserByUserName("sniff");
        member.setPassword("123456");
        Member result = memberService.register(member);
        assertTrue("password check fail", passwordEncoder.matches("123456", result.getPassword()));
        assertEquals("register fail", member.getUserName(), result.getUserName());
        System.out.println(member.getId());
    }
    @Test
    public void queryByUserName() throws Exception {
        Member member = memberService.queryByUserName("sniff");
        System.out.println(member);
        assertNotNull("queryByUserName fail.params sniff", member);
    }

    @Test
    public void queryById() throws Exception {
        Optional<Member> customer = memberService.queryById("5b4ca6dc5797e180fb10bfea");
        System.out.println(customer.get());
        assertTrue("queryById fail.params 5b4b1c535797e1260e8693ce", customer.isPresent());
    }

    @Test
    public void deleteById() throws Exception {
        memberService.deleteById("5b4b1c745797e1261a93ded2");
    }

    @Test
    public void disableByUserName() throws Exception {
        long flag = memberService.disableByUserName("sniff");
        Optional<Member> customer = memberService.queryById("5b4ca6dc5797e180fb10bfea");
        System.out.println(customer.get());
        assertTrue("disableByUserName fail.param sniff", flag == 1);
        assertTrue("disableByUserName fail.params sniff", customer.orElse(new Member()).getStatus() == 1);
    }

    @Test
    public void existsById() throws Exception {
        assertTrue("existsById fail.params 5b4ca6dc5797e180fb10bfea", memberService.existsById("5b4ca6dc5797e180fb10bfea"));
        assertFalse("existsById fail.params 5b4ca6dc5797e180fb10bfea", memberService.existsById("1"));
    }

    @Test
    public void enableById() throws Exception {
        memberService.enableById("5b4ca6dc5797e180fb10bfea");
        Optional<Member> customer = memberService.queryById("5b4ca6dc5797e180fb10bfea");
        System.out.println(customer.get());
        assertTrue("disableByUserName fail.params sniff", customer.orElse(new Member()).getStatus() == 0);
    }

    @Test
    public void enableByUserName() throws Exception {
        memberService.enableByUserName("sniff");
        Optional<Member> customer = memberService.queryById("5b4ca6dc5797e180fb10bfea");
        System.out.println(customer.get());
        assertTrue("disableByUserName fail.params sniff", customer.orElse(new Member()).getStatus() == 0);
    }


}