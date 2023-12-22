import React from "react";
import { useUserInfo } from "../store/userInfo";
import { Navigate, Outlet } from "react-router-dom";

const PrivateRoutes = () => {
  const user = useUserInfo((state) => state.user);

  if (user.token) {
    return <Outlet />;
  } else {
    return <Navigate to={"/auth/login/"} />;
  }
};

export default PrivateRoutes;
