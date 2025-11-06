'use client'

type Vehicle = { id:number; brandId:number; brandName:string; modelId:number; modelName:string; year:number; color:string; price:number; mileage:number; status:string }

type Props = { data: Vehicle[] }

export default function VehiclesTable({ data }: Props) {
  return (
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Marca</th>
          <th>Modelo</th>
          <th>Ano</th>
          <th>Cor</th>
          <th>Preço</th>
          <th>KM</th>
          <th>Status</th>
        </tr>
      </thead>
      <tbody>
        {data.map(v => (
          <tr key={v.id}>
            <td>{v.id}</td>
            <td>{v.brandName}</td>
            <td>{v.modelName}</td>
            <td>{v.year}</td>
            <td>{v.color}</td>
            <td>{v.price.toLocaleString(undefined,{minimumFractionDigits:2, maximumFractionDigits:2})}</td>
            <td>{v.mileage.toLocaleString()}</td>
            <td>{v.status}</td>
          </tr>
        ))}
      </tbody>
    </table>
  )
}


