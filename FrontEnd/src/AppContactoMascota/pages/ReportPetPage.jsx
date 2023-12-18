import Layout from "../../ui/Layout";
import { FormLostPet } from "../components/FormLostPet";

export const ReportPetPage = () => {
  return (
    <Layout>
      <main className="max-w-[1200px] mx-auto bg-orange mb-4">
        <h1 className="text-3xl md:text-5xl font-bold text-center py-6">
          Reportar Mascota
        </h1>
        <FormLostPet/>
      </main>
    </Layout>
  );
};
