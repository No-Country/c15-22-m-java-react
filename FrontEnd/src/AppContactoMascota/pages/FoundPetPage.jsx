import Layout from "../../ui/Layout";
import { FormFoundPet } from "../components/FormFoundPet";
import photoimage from "/girl_and_dog.png";

export const FoundPetPage = () => {
  return (
    <Layout>
      <main className="max-w-screen-xl mx-auto p-4 grid grid-cols-1 md:grid-cols-2 justify-center items-center">
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
          <h1 className="text-2xl font-bold my-4 text-center">
            Reportar Mascota Encontrada
          </h1>
          <FormFoundPet />
        </section>
      </main>
    </Layout>
  );
};
