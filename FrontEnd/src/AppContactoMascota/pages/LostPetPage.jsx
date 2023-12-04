import Layout from "../../ui/Layout";
import { FormLostPet } from "../components/FormLostPet";
import photoimage from "/girl_and_dog.png";

export const LostPetPage = () => {
  return (
    <Layout>
      <main className="max-w-screen-xl mx-auto p-4 grid grid-cols-1 md:grid-cols-2">
        <section>
          <img
            src={photoimage}
            alt="contacto mascota"
            width="500"
            height="500"
            className="w-full"
          />
        </section>
        <section>
          <h1 className="text-2xl font-bold text-center mb-5">
            Reportar Mascota Perdida
          </h1>
          <FormLostPet />
        </section>
      </main>
    </Layout>
  );
};
