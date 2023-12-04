import Layout from "../../ui/Layout";
import { FormFoundPet } from "../components/FormFoundPet";
import photoimage from "/girl_and_dog.png";

export const FoundPetPage = () => {
  return (
    <Layout>
      <main className="container mx-auto grid grid-cols-1 md:grid-cols-2 justify-center items-center">
        <section>
          <img
            src={photoimage}
            alt="contacto mascota"
            width="500"
            height="500"
          />
        </section>
        <section className="flex flex-col w-full justify-center items-center p-0 m-0">
          <h1 className="text-2xl font-bold my-4">
            Reportar Mascota Encontrada
          </h1>
          <FormFoundPet />
        </section>
      </main>
    </Layout>
  );
};
