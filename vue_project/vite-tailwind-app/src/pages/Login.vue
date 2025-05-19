<template>
  <div
    class="flex flex-col items-center justify-center min-h-screen max-w-md w-full mx-auto px-4"
  >
    <h1 class="text-2xl font-bold mb-4">로그인</h1>
    <BaseInput v-model="form.email" type="email" placeholder="이메일" />
    <BaseError
      v-if="
        form.email &&
        !/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/.test(form.email)
      "
      error
    >
      올바른 이메일 형식을 입력해주세요.
    </BaseError>

    <BaseInput v-model="form.password" type="password" placeholder="비밀번호" />

    <BaseButton @click="handleSubmit">로그인</BaseButton>

    <router-link to="/signup" class="text-blue-500 hover:underline mt-4">
      회원가입
    </router-link>
  </div>
</template>

<script setup>
import { reactive } from "vue";
import axios from "axios";
import BaseInput from "../components/base/BaseInput.vue";
import BaseButton from "../components/base/BaseButton.vue";
import BaseError from "../components/base/BaseError.vue";
import { useRouter } from "vue-router";

const router = useRouter();

const form = reactive({
  email: "",
  password: "",
});

const handleSubmit = async () => {
  try {
    // 빈 값 확인 검사
    if (form.password === "" || form.email === "") {
      alert("모든 값을 입력해주세요.");
      return;
    }

    // 이메일 형식 검사
    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (!emailPattern.test(form.email)) {
      alert("올바른 이메일 형식을 입력해주세요.");
      return;
    }

    // 로그인 API 호출
    const payload = {
      email: form.email,
      pwd: form.password,
    };

    const res = await axios.post(
      "http://222.117.237.119:8111/auth/login",
      payload
    );
    if (res.data) {
      //alert("로그인 성공");
      localStorage.setItem("isLogin", "TRUE");
      router.push("/home");
    } else {
      alert("로그인 실패");
    }
  } catch (err) {
    console.error(err);
    alert("로그인 실패! 서버 오류 발생");
  }
};
</script>
