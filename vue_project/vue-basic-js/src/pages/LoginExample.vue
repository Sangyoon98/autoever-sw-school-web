<template>
  <h2>Sign Up</h2>
  <div class="form_container">
    <input
      v-model="form.email"
      type="email"
      name="email"
      id="email"
      placeholder="이메일"
    />
    <p
      v-if="
        form.email &&
        !/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/.test(form.email)
      "
      style="color: red"
    >
      올바른 이메일 형식을 입력해주세요.
    </p>

    <input
      v-model="form.password"
      type="password"
      name="password"
      id="password"
      placeholder="비밀번호"
    />

    <input
      v-model="form.password_check"
      type="password"
      name="password_check"
      id="password_check"
      placeholder="비밀번호 확인"
    />
    <p
      v-if="form.password !== form.password_check && form.password_check"
      style="color: red"
    >
      비밀번호가 일치하지 않습니다.
    </p>

    <input
      v-model="form.name"
      type="text"
      name="name"
      id="name"
      placeholder="이름"
    />

    <button @click="handleSubmit">회원가입</button>
  </div>
</template>

<script setup>
import { reactive } from "vue";
import axios from "axios";

const form = reactive({
  email: "",
  password: "",
  password_check: "",
  name: "",
});

const handleSubmit = async () => {
  try {
    // 빈 값 확인 검사
    if (
      form.password === "" ||
      form.email === "" ||
      form.password_check === "" ||
      form.name === ""
    ) {
      alert("모든 값을 입력해주세요.");
      return;
    }

    // 이메일 형식 검사
    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (!emailPattern.test(form.email)) {
      alert("올바른 이메일 형식을 입력해주세요.");
      return;
    }

    // 비밀번호 확인 검사
    if (form.password !== form.password_check) {
      alert("비밀번호가 일치하지 않습니다.");
      return;
    }

    const payload = {
      email: form.email,
      pwd: form.password,
      name: form.name,
    };
    const res = await axios.post(
      "http://222.117.237.119:8111/auth/signup",
      payload
    );
    if (res.data) {
      alert("회원 가입 성공");
    } else {
      alert("회원 가입 실패");
    }
  } catch (err) {
    console.error(err);
    alert("가입 실패! 서버 오류 발생");
  }
};
</script>

<style scoped>
.form_container {
  width: 500px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

p {
  margin: 0;
  padding: 0;
}

input {
  width: 100%;
  margin: 10px;
  padding: 15px;
  border: 1px solid #ccc;
  border-radius: 100px;
}

button {
  width: 100%;
  margin-top: 30px;
}
</style>
