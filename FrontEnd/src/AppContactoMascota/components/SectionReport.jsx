import { Link } from "react-router-dom";

const SectionReport = () => {
  return (
    <section className="bg-white my-16">
      <h2 className="text-3xl md:text-5xl font-bold text-center py-6">Reportar Mascota</h2>
      <div className="text-center">
        <p className="text-md md:text-xl">
          ¿Quieres reportar tu mascota perdida? o ¿Quieres reportar una mascota
          encontrada?
        </p>
        <Link
          to={"/auth/dashboard"}
          type="button"
          className="bg-orange-200 py-2 px-4 rounded-md mt-2"
        >
          Hazlo aquí
        </Link>
      </div>
    </section>
  );
};

export default SectionReport;
