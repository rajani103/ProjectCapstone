import axios from "axios"

const login = async (values) => {
        return await axios.post("http://localhost:8080/authentication-service/api/v1/auth/login", values)
} 

const addSlot = async (values) => {
        return await axios.post("http://localhost:8080/interviewer-service/api/v1/int/addSlot", values)
} 

const updateSlot = async (id, slotStatus,values) => {
        return await axios.put(`http://localhost:8080/interviewer-service/api/v1/int/update/${id}/${slotStatus}`, values)
} 

const getAllSlots = async () => {
        return await axios.get("http://localhost:8080/tag-team-service/tag/api/v1/tag/getAllBookedSlots")
} 

const changeSlotStatus = async(bookSlotId,status) => { 
        return await axios.put(`http://localhost:8080/tag-team-service/tag/api/v1/tag/slotStatus/${bookSlotId}/${status}`)
}


const SLOTS = [
        "BOOKED","AVAILABLE","UNAVAILABLE","CANCELLED","COMPLETED"
]



const getSlot = async (email) => {
        return await axios.get(`http://localhost:8080/interviewer-service/api/v1/int/getSlotByInterviewerEmail/${email}`)
} 



export {login, addSlot , updateSlot, getSlot, getAllSlots, SLOTS, changeSlotStatus}