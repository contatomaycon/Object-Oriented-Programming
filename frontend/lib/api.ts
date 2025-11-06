// Get API base URL
// In browser: use NEXT_PUBLIC_API_BASE_URL or default to http://localhost:8080
// Empty string means use Next.js rewrites (relative path)
const getApiBase = (): string => {
  if (typeof window !== 'undefined') {
    // Client-side: prefer environment variable, fallback to localhost:8080
    return process.env.NEXT_PUBLIC_API_BASE_URL || 'http://localhost:8080';
  }
  // Server-side: use environment variable or default to localhost
  return process.env.NEXT_PUBLIC_API_BASE_URL || process.env.API_BASE_URL || 'http://localhost:8080';
};

export const API_BASE = getApiBase();

export async function api<T>(path: string, init?: RequestInit): Promise<T> {
  const url = `${API_BASE}/api${path}`;

  console.log('API_BASE', API_BASE);
  console.log('url', url);
  
  try {
    const res = await fetch(url, { 
      cache: "no-store", 
      ...init,
      headers: {
        'Content-Type': 'application/json',
        ...init?.headers,
      },
    });
    if (!res.ok) {
      const errorText = await res.text().catch(() => 'Unknown error');
      throw new Error(`Request failed: ${res.status} ${res.statusText} - ${errorText}`);
    }
    return res.json();
  } catch (error) {
    if (error instanceof TypeError && error.message.includes('Failed to fetch')) {
      throw new Error(`Failed to connect to API at ${url}. Make sure the backend is running at ${API_BASE}`);
    }
    throw error;
  }
}


