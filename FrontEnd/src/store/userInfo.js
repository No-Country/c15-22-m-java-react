import { create } from "zustand";
import { persist } from "zustand/middleware";

const INITIAL_STATE = {
  email: "",
  name: "",
  token: "",
};

export const useUserInfo = create(
  persist(
    (set) => ({
      user: INITIAL_STATE,
      login: (infoLogin) => {
        set({ user: infoLogin });
      },
      logout: () => {
        set({user: INITIAL_STATE})
        localStorage.removeItem("userInfo")
      }
    }),
    {
      name: "userInfo",
    }
  )
);
