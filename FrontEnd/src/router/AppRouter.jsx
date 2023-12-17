import { Routes, Route, Navigate } from "react-router-dom";

import {
  FoundPetPage,
  HappyEndings,
  Home,
  LostPetPage,
} from "../AppContactoMascota/pages";
import Login from "../AppContactoMascota/components/Login";
import Register from "../AppContactoMascota/components/Register";
import Page404 from "../AppContactoMascota/pages/Page404";
import PrivateRoutes from "../auth/PrivateRoutes";

export const AppRouter = () => {
  return (
    <Routes>
      <Route path="/auth/login" element={<Login />} />
      <Route path="/auth/register" element={<Register />} />
      <Route path="/finalesfelices" element={<HappyEndings />} />
      <Route path="/" index element={<Home />} />

      <Route element={<PrivateRoutes />}>
        <Route path="/*" element={<Navigate to="/" />} />
        <Route path="/auth/mascotaencontrada" element={<FoundPetPage />} />
        <Route path="/auth/mascotaperdida" element={<LostPetPage />} />
      </Route>

      <Route path="*" element={<Page404 />} />
    </Routes>
  );
};
