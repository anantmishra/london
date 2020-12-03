package uk.gov.hmrc.london.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    public void testEqualsAndHashCode() {
        User user1 = new User();
        user1.setId(1);
        User user2 = new User();
        user2.setId(2);
        User user3 = new User();
        user3.setId(1);

        assertThat(user1.equals(user2)).isFalse();
        assertThat(user1.equals(user3)).isTrue();
        assertThat(user1.hashCode()).isNotEqualTo(user2.hashCode());
        assertThat(user1.hashCode()).isEqualTo(user3.hashCode());
    }
}