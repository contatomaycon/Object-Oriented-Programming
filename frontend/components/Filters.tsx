'use client'
import { useEffect, useMemo, useState } from 'react'
import { api } from '@/lib/api'

type Brand = { id: number; name: string }
type Model = { id: number; name: string; brandId: number; brandName: string }

type Props = { onChange: (v: { brandId?: number; modelId?: number; year?: number; status?: string; minPrice?: number; maxPrice?: number }) => void }

export default function Filters({ onChange }: Props) {
  const [brands, setBrands] = useState<Brand[]>([])
  const [models, setModels] = useState<Model[]>([])
  const [brandId, setBrandId] = useState<string>('')
  const [modelId, setModelId] = useState<string>('')
  const [year, setYear] = useState<string>('')
  const [status, setStatus] = useState<string>('')
  const [minPrice, setMinPrice] = useState<string>('')
  const [maxPrice, setMaxPrice] = useState<string>('')

  useEffect(() => { api<Brand[]>(`/brands`).then(setBrands) }, [])
  useEffect(() => { if (brandId) api<Model[]>(`/models?brandId=${brandId}`).then(setModels); else setModels([]) }, [brandId])

  const submit = () => {
    onChange({
      brandId: brandId ? Number(brandId) : undefined,
      modelId: modelId ? Number(modelId) : undefined,
      year: year ? Number(year) : undefined,
      status: status || undefined,
      minPrice: minPrice ? Number(minPrice) : undefined,
      maxPrice: maxPrice ? Number(maxPrice) : undefined
    })
  }

  const reset = () => {
    setBrandId(''); setModelId(''); setYear(''); setStatus(''); setMinPrice(''); setMaxPrice(''); onChange({})
  }

  const statusList = useMemo(() => ["AVAILABLE","SOLD","DISCONTINUED"], [])

  return (
    <div style={{ display:'grid', gridTemplateColumns:'repeat(6,1fr)', gap:'.6rem', alignItems:'end' }}>
      <div>
        <label>Marca</label>
        <select value={brandId} onChange={e=>{setBrandId(e.target.value); setModelId('')}}>
          <option value="">Todas</option>
          {brands.map(b=> <option key={b.id} value={b.id}>{b.name}</option>)}
        </select>
      </div>
      <div>
        <label>Modelo</label>
        <select value={modelId} onChange={e=>setModelId(e.target.value)} disabled={!brandId}>
          <option value="">Todos</option>
          {models.map(m=> <option key={m.id} value={m.id}>{m.name}</option>)}
        </select>
      </div>
      <div>
        <label>Ano</label>
        <input type="number" value={year} onChange={e=>setYear(e.target.value)} placeholder="Ex: 2022" />
      </div>
      <div>
        <label>Status</label>
        <select value={status} onChange={e=>setStatus(e.target.value)}>
          <option value="">Todos</option>
          {statusList.map(s=> <option key={s} value={s}>{s}</option>)}
        </select>
      </div>
      <div>
        <label>Preço mín</label>
        <input type="number" value={minPrice} onChange={e=>setMinPrice(e.target.value)} placeholder="0" />
      </div>
      <div>
        <label>Preço máx</label>
        <input type="number" value={maxPrice} onChange={e=>setMaxPrice(e.target.value)} placeholder="100000" />
      </div>
      <div style={{ gridColumn:'span 6', display:'flex', gap:'.6rem' }}>
        <button onClick={submit}>Filtrar</button>
        <button onClick={reset}>Limpar</button>
      </div>
    </div>
  )
}


