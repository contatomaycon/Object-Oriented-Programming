'use client'
import { useEffect, useState } from 'react'
import { api } from '@/lib/api'
import Filters from '@/components/Filters'
import VehiclesTable from '@/components/VehiclesTable'

type PageResponse<T> = { content:T[] }
type Query = { brandId?: number; modelId?: number; year?: number; status?: string; minPrice?: number; maxPrice?: number }
type Vehicle = { id:number; brandId:number; brandName:string; modelId:number; modelName:string; year:number; color:string; price:number; mileage:number; status:string }

export default function Page() {
  const [query, setQuery] = useState<Query>({})
  const [data, setData] = useState<Vehicle[]>([])
  const [loading, setLoading] = useState(false)

  const fetchData = async (q: Query) => {
    setLoading(true)
    const params = new URLSearchParams()
    if (q.brandId) params.append('brandId', String(q.brandId))
    if (q.modelId) params.append('modelId', String(q.modelId))
    if (q.year) params.append('year', String(q.year))
    if (q.status) params.append('status', q.status)
    if (q.minPrice) params.append('minPrice', String(q.minPrice))
    if (q.maxPrice) params.append('maxPrice', String(q.maxPrice))
    const res = await api<PageResponse<Vehicle>>(`/vehicles?${params.toString()}`)
    setData(res.content)
    setLoading(false)
  }

  useEffect(() => { fetchData(query) }, [JSON.stringify(query)])

  return (
    <main style={{ maxWidth: 1100, margin: '2rem auto', padding: '0 1rem' }}>
      <h1>Estoque de Veículos</h1>
      <Filters onChange={setQuery} />
      {loading ? <p>Carregando...</p> : <VehiclesTable data={data} />}
    </main>
  )
}


