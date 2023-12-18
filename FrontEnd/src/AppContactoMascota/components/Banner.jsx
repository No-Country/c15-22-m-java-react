import { useContactoMascota } from "../../hooks/useContactoMascota";
import { getImageOfBase64 } from "../helpers/getImageOfBase64";
import { LastPetsCards } from "./LastPetsCards";

const Banner = () => {
  const { lastPets } = useContactoMascota();

  const renderPets = () => {
    if (lastPets.length > 0) {
      return lastPets.map((pet) => <LastPetsCards key={pet.id} pet={pet} />);
    }
  };

  return (
    <section className="bg-red-primary pb-10">
      <h1 className="text-3xl md:text-5xl font-bold text-center text-white py-6">
        Últimas mascotas <br /> reportadas
      </h1>
      <div className="grid gap-10 justify-center grid-cols-[repeat(auto-fit,_260px)] max-w-[1240px] mx-auto items-center">
        {/* ----> Acá va renderizar las ultimas mascotas reportadas <------  */}

        {/* <img className="max-h-[800px]" src="/images/nua.png" alt="" />
        <img className=" max-h-[800px]" src="/images/nua.png" alt="" />
        <img className=" max-h-[800px]" src="/images/nua.png" alt="" /> */}
        {renderPets()}
      </div>
    </section>
  );
};

export default Banner;
