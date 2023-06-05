package Hello.core.discount;

import Hello.core.member.Grade;
import Hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인을 받아야한다.")
    void vip_o() {
        //given
        Member member = new Member(1L, "Song", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(1000);

    }

    @Test
    @DisplayName("일반 회원은 할인이 적용되면 안된다.")
    void vip_x() {
        //given
        Member member = new Member(1L, "Song", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(0);
    }
}