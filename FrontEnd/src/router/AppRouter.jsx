import { Routes, Route, Navigate } from "react-router-dom";

import {
  DashboardPage,
  FoundPetPage,
  HappyEndings,
  Home,
  LostPetPage,
  ReportPetPage,
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
      <Route path="/mascotasperdidas" element={<LostPetPage />} />
      <Route path="/mascotasencontradas" element={<FoundPetPage />} />
      <Route path="/" index element={<Home />} />

      <Route element={<PrivateRoutes />}>
        <Route path="/*" element={<Navigate to="/" />} />
        <Route path="/auth/dashboard" element={<DashboardPage />} />
        <Route path="/auth/reportarmascota" element={<ReportPetPage />} />
      </Route>

      <Route path="*" element={<Page404 />} />
    </Routes>
  );
};
