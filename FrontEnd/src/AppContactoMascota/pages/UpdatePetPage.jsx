import { useState, useEffect } from "react";
import { useContactoMascota } from "../../hooks/useContactoMascota";
import Layout from "../../ui/Layout";
import FormUpdatePet from "../components/FormUpdatePet";
import { getImageOfBase64 } from "../helpers/getImageOfBase64";

export const UpdatePetPage = () => {
  const { petPage } = useContactoMascota();
  const [currentImage, setCurrentImage] = useState("");

  useEffect(() => {
    if (Object.values(petPage).length > 0) {
      const {
        image: { imageBase64 },
      } = petPage;

      getImageOfBase64(imageBase64, (imagen) => {
        setCurrentImage(imagen);
      });
      
    }
  }, [petPage]);

  return (
    <Layout>
      <main className="max-w-[1200px] mx-auto bg-orange mb-4">
        <h1 className="text-3xl md:text-5xl font-bold text-center py-6">
          Actualizar reporte de mascota
        </h1>

        <section className="grid grid-cols-1 md:grid-cols-2">
          {currentImage && (
            <img
              src={currentImage}
              alt={petPage?.name}
              width="300"
              height="300"
              className="object-cover w-2/3 mx-auto"
            />
          )}
          <FormUpdatePet />
        </section>
      </main>
    </Layout>
  );
};
