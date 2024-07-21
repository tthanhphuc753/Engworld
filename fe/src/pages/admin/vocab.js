import { FaMagnifyingGlass } from "react-icons/fa6";
const vocabulary = [
    {
      text: "serendipity",
      gern: "",
      ipa: "",
      mean: "the occurrence of events by chance in a happy or beneficial way",
      example: "She encountered her old friend by serendipity at the airport."
    },
    {
      text: "ambivalent",
      gern: "",
      ipa: "",
      mean: "having mixed feelings or contradictory ideas about something or someone",
      example: "He felt ambivalent about leaving his job."
    },
    {
      text: "cacophony",
      gern: "",
      ipa: "",
      mean: "a harsh, discordant mixture of sounds",
      example: "The cacophony of the city streets was overwhelming."
    },
    {
      text: "ephemeral",
      gern: "",
      ipa: "",
      mean: "lasting for a very short time",
      example: "The beauty of the sunset was ephemeral."
    },
    {
      text: "quixotic",
      gern: "",
      ipa: "",
      mean: "exceedingly idealistic; unrealistic and impractical",
      example: "His quixotic plans for world peace seemed admirable but impractical."
    },
    {
      text: "ubiquitous",
      gern: "",
      ipa: "",
      mean: "present, appearing, or found everywhere",
      example: "The ubiquitous presence of smartphones has changed the way we communicate."
    },
    {
      text: "veracity",
      gern: "",
      ipa: "",
      mean: "truthfulness, accuracy",
      example: "Her veracity in recounting the events was unquestionable."
    },
    {
      text: "zenith",
      gern: "",
      ipa: "",
      mean: "the highest point reached by a celestial or other object",
      example: "The team reached the zenith of their success with the championship win."
    },
    {
      text: "equivocate",
      gern: "",
      ipa: "",
      mean: "use ambiguous language so as to conceal the truth or avoid committing oneself",
      example: "Politicians often equivocate when addressing controversial issues."
    },
    {
      text: "mellifluous",
      gern: "",
      ipa: "",
      mean: "sweet or musical; pleasant to hear",
      example: "Her mellifluous voice captivated everyone in the room."
    }
  ];
  
export default function Vocabulary(){
    const handleSearchChange = () => {

    }
    const handlefind = () =>{

    }
    return (
        <div><div className="flex flex-col justify-center items-center m-5">
        <div className="flex items-center justify-center w-full mb-5">
            <input type="text" className="border border-e-0 rounded-tl-full rounded-bl-full w-1/3 p-2 focus:outline-none pl-4" placeholder="Type here..." onChange={handleSearchChange} />
            <button className="bg-blue-500 text-white p-3 border pr-4 rounded-tr-full rounded-br-full " onClick={handlefind}>
                <FaMagnifyingGlass />
            </button>
            <button className="bg-blue-500 text-white py-2 px-10 border rounded-full" onClick={handlefind}>
                Add
            </button>
        </div>
        <table className="w-full border">
            <thead>
                <tr>
                    <th className="border">Text</th>
                    <th className="border">Gern</th>
                    <th className="border">IPA</th>
                    <th className="border">Mean</th>
                    <th className="border">Example</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                {vocabulary.map((v, index) => (
                    <tr key={index}>
                        <td className="border">{v.text}</td>
                        <td className="border">{v.gern}</td>
                        <td className="border">{v.ipa}</td>
                        <td className="border">{v.mean}</td>
                        <td className="border">{v.example}</td>
                        <td className="border">
                            <button className="bg-red-500 text-white mx-4 py-2 px-4 rounded-full">delete</button>
                        </td>
                    </tr>
                ))}
            </tbody>
        </table>
    </div></div>
    )
}