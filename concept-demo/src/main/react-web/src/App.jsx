import { useState } from 'react'
import StudentList from './component/StudentList'

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className="App">
      <StudentList />
    </div>
  )
}

export default App
