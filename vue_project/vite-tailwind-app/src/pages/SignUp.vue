<template>
  <div
    class="flex flex-col items-center justify-center min-h-screen max-w-md w-full mx-auto px-4"
  >
    <h2 class="font-bold text-4xl mb-10">Sign Up</h2>
    <div>
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

      <BaseInput
        v-model="form.password"
        type="password"
        placeholder="비밀번호"
      />

      <BaseInput
        v-model="form.password_check"
        type="password"
        placeholder="비밀번호 확인"
      />
      <BaseError
        v-if="form.password !== form.password_check && form.password_check"
        error
      >
        비밀번호가 일치하지 않습니다.
      </BaseError>

      <BaseInput v-model="form.name" type="text" placeholder="이름" />

      <BaseButton @click="handleSubmit">회원가입</BaseButton>
    </div>
  </div>
</template>

<script setup>
import { reactive } from "vue";
import axios from "axios";
import BaseInput from "../components/base/BaseInput.vue";
import BaseButton from "../components/base/BaseButton.vue";
import BaseError from "../components/base/BaseError.vue";
import { useRouter } from "vue-router";
import { useModalStore } from "../stores/modal";
import { useAuthApi } from "../api/auth";

const { signup, exists } = useAuthApi();
const router = useRouter();

const modalStore = useModalStore();

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
      modalStore.openModal({
        title: "회원가입 실패",
        message: "모든 값을 입력해주세요.",
      });
      return;
    }

    // 이메일 형식 검사
    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (!emailPattern.test(form.email)) {
      modalStore.openModal({
        title: "회원가입 실패",
        message: "올바른 이메일 형식을 입력해주세요.",
      });
      return;
    }

    // 비밀번호 확인 검사
    if (form.password !== form.password_check) {
      modalStore.openModal({
        title: "회원가입 실패",
        message: "비밀번호가 일치하지 않습니다.",
      });
      return;
    }

    const payload = {
      email: form.email,
      pwd: form.password,
      name: form.name,
    };

    const exist = await exists(form.email);

    // const exist = await axios.get(
    //   `http://222.117.237.119:8111/auth/exists/${form.email}`
    // );
    if (exist.data === false) {
      modalStore.openModal({
        title: "회원가입 실패",
        message: "이미 가입된 이메일입니다.",
      });
    } else {
      const res = await signup(form.email, form.password, form.name);
      // const res = await axios.post(
      //   "http://222.117.237.119:8111/auth/signup",
      //   payload
      // );
      if (res.data) {
        modalStore.openModal({
          title: "회원가입 성공",
          message: "회원가입이 완료되었습니다.",
        });
        router.push("/");
      } else {
        modalStore.openModal({
          title: "회원가입 실패",
          message: "다시 시도해주세요.",
        });
      }
    }
  } catch (err) {
    console.error(err);
    modalStore.openModal({
      title: "회원가입 실패",
      message: "서버 오류 발생",
    });
  }
};
</script>
