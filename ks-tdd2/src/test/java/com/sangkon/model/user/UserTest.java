package com.sangkon.model.user;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @Test
    public void createPojoUserBuilder() {
        User user = User.builder().build();
        assertThat(user).isNotNull();
    }

// 2. POJO(Plain Old Java Object)의 첫 번째 특성인 기본 생성자
    @Test
    public void createPojoUserConstructor() {
        User user = new User();
        assertThat(user).isNotNull();
    }

// 3. POJO의 특성인 Setter/Getter
    @Test
    public void createPojoUserSetterGetter() {
        User user = User.builder().name("name").build();
        assertThat(user.getName()).isEqualTo("name");
        user.setName("name2");
        assertThat(user.getName()).isEqualTo("name2");
    }

// 4. POJO의 특성인 id(unique)
    @Test
    public void createPojoUserById() {
        User user = User.builder().id(3L).name("name").build();
        User user2 = User.builder().id(3L).name("name22").build();
        assertThat(user).isEqualTo(user2);

    }

}