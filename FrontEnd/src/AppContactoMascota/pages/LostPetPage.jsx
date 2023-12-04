import Layout from "../../ui/Layout";
import { FormLostPet } from "../components/FormLostPet";
import photoimage from "/girl_and_dog.png";

export const LostPetPage = () => {
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
          <h1 className="text-2xl font-bold my-4">Reportar Mascota Perdida</h1>
          <FormLostPet />
        </section>
      </main>
    </Layout>
  );
};
